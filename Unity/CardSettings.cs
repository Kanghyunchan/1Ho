using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;

public class CardSettings : MonoBehaviour
{

    public string fieldSkill = "적 한 명을 지정하여 10의 데미지를 주고 벤치에 있는 아군의 체력을 10회복 시킨다.";
    public string benchSkill = "아군 한 명을 지정하여 체력을 5회복 시킨다.";

    private GameObject inforText;

    // Start is called before the first frame update
    void Start()
    {
        inforText = GameObject.Find("Parchment").transform.GetChild(0).gameObject;
    }

    // Update is called once per frame
    void Update()
    {

    }
    public void OnMouseDown()
    {
        inforText.GetComponent<SkillText>().Infor(fieldSkill, benchSkill);
        Debug.Log("이미지 클릭 실행됨.");
    }
}
