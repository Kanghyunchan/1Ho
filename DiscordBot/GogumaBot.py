import discord
from discord.ext import commands
from youtube_dl import YoutubeDL
import bs4
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from discord.utils import get
from discord import FFmpegPCMAudio
import asyncio
import time

bot = commands.Bot(command_prefix = "$")

@bot.event
async def on_ready():
    print("다음으로 로그인합니다: ")
    print(bot.user.name)
    print("connection was succesful")
    game = discord.Game("$도움말")
    await bot.change_presence(status = discord.Status.online, activity = game)

@bot.command()
async def 따라하기(ctx, *, text):
    await ctx.send(text)

@bot.command()
async def join(ctx):
    print(ctx.author.voice)
    try:
        global vc
        vc = await ctx.message.author.voice.channel.connect()
        print(str(bot.user.name) + "봇이 " + str(ctx.author.voice.channel) + "에 접속하였습니다.")
    except:
        try:
            await vc.move_to(ctx.message.author.voice.channel)
            print(str(bot.user.name) + "봇이 " + str(ctx.author.voice.channel) + "로 이동하였습니다.")
        except:
            await ctx.send("채널에 유저가 접속해있지 않습니다.")

@bot.command()
async def leave(ctx):
    try:
        await vc.disconnect()
    except:
        await ctx.send("이미 그 채널에 존재하지 않습니다.")

@bot.command()
async def play(ctx, *, url):
    YDL_OPTIONS = {'format': 'bestaudio','noplaylist':'True'}
    FFMPEG_OPTIONS = {'before_options': '-reconnect 1 -reconnect_streamed 1 -reconnect_delay_max 5', 'options': '-vn'}

    if not vc.is_playing():
        with YoutubeDL(YDL_OPTIONS) as ydl:
            info = ydl.extract_info(url, download=False)
        URL = info['formats'][0]['url']
        vc.play(FFmpegPCMAudio(URL, **FFMPEG_OPTIONS))
        await ctx.send(embed = discord.Embed(title= "노래 재생", description = "현재 " + url + "을(를) 재생하고 있습니다.", color = 0xFE2E9A))
    else:
        await ctx.send("노래가 이미 재생되고 있습니다!")

@bot.command()
async def 도움말(ctx):
    helpText = "$help : 명령어목록\n $join : 음성방에 봇 들어오기\n $leave : 음성방에 봇 내보내기\n $play (URL) : URL의 노래 재생"
    embed = discord.Embed(title = "고구마봇 명령어", description = helpText, color = 0xFE2E9A)
    embed.set_thumbnail(url = "https://imgur.com/JEY4W5O")
    await ctx.send(embed = embed)

bot.run("your token")
