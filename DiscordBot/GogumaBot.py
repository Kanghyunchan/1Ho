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
    embed.set_thumbnail(url = "https://i.imgur.com/JEY4W5O.png")
    await ctx.send(embed = embed)

@bot.command()
async def 재생(ctx, *, msg):
    if not vc.is_playing():
        global entireText
        YDL_OPTIONS = {'format': 'bestaudio','noplaylist':'True'}
        FFMPEG_OPTIONS = {'before_options': '-reconnect 1 -reconnect_streamed 1 -reconnect_delay_max 5', 'options': '-vn'}

        chromedriver_dir = "C:\\Users\\user\\Desktop\\파이썬\\chromedriver.exe"
        driver = webdriver.Chrome(chromedriver_dir)
        driver.get("https://www.youtube.com/results?search_query="+msg+"+lyrics")
        source = driver.page_source
        bs = bs4.BeautifulSoup(source, "lxml")
        entire = bs.find_all("a", {"id": "video-title"})
        entireNum = entire[0]
        entireText = entireNum.text.strip()
        musicurl = entireNum.get("href")
        url = "https://www.youtube.com" + musicurl

        with YoutubeDL(YDL_OPTIONS) as ydl:
            info = ydl.extract_info(url, download = False)
        URL = info["formats"][0]["url"]
        await ctx.send(embed = discord.Embed(title= "노래 재생", description= "현재" + entireText + "을(를) 재생하고 있습니다.", color = 0xFE2E9A))
        vc.play(FFmpegPCMAudio(URL, **FFMPEG_OPTIONS))
    else:
        await ctx.send("이미 노래가 재생 중이라 노래를 재생할 수 없어요!")

@bot.command()
async def pause(ctx):
    if vc.is_playing():
        vc.pause()
        await ctx.send(embed = discord.Embed(title= "일시정지", description = entireText + "을(를) 일시정지 했습니다.", color = 0xFE2E9A))
    else:
        await ctx.send("지금 노래가 재생되지 않네요.")

@bot.command()
async def replay(ctx):
    try:
        vc.resume()
    except:
        await ctx.send("지금 노래가 재생되지 않네요.")
    else:
        await ctx.send(embed = discord.Embed(title= "다시재생", description = entireText  + "을(를) 다시 재생했습니다.", color = 0xFE2E9A))

@bot.command()
async def stop(ctx):
    if vc.is_playing():
        vc.stop()
        await ctx.send(embed = discord.Embed(title= "노래끄기", description = entireText  + "을(를) 종료했습니다.", color = 0xFE2E9A))
    else:
        await ctx.send("지금 노래가 재생되지 않네요.")

bot.run("your token")
