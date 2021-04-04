using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
[System.Serializable]
public class CardList
{
    public int id; //각 카드의 아이디
    public string cardName; //각 카드의 이름
    public string rating; //각 카드의 레어도
    public int damage; //각 카드의 공격력
    public int health; //각 카드의 체력
    public string synergy; //각 카드의 시너지속성
    public int mana; //각 카드의 마나 
    public string fieldSkill; //각 카드의 필드스킬
    public string benchSkill; //각 카드의 벤치스킬
    public string job; // 각 카드의 직업

    public Sprite characterImage;
    public Sprite synergyRightImage;
    public Sprite synergyLeftImage;
    public Sprite backgroundImage;
    public CardList()
    {

    }

    public CardList(int Id, string CardName, string Rating, int Damage, int Health, string Synergy, 
        int Mana, string FieldSkill, string BenchSkill, string Job, Sprite CharacterImage, 
        Sprite SynergyRightImage, Sprite SynergyLeftImage, Sprite BackgroundImage)
    {
        id = Id;
        cardName = CardName;
        rating = Rating;
        damage = Damage;
        health = Health;
        synergy = Synergy;
        mana = Mana;
        fieldSkill = FieldSkill;
        benchSkill = BenchSkill;
        job = Job;

        characterImage = CharacterImage;
        synergyRightImage = SynergyRightImage;
        synergyLeftImage = SynergyLeftImage;
        backgroundImage = BackgroundImage;
    }
}
