using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class SkillText : MonoBehaviour
{
    private GameObject fieldText,benchText;
    
    // Start is called before the first frame update
    void Start()
    {
        fieldText = transform.GetChild(0).gameObject;
        benchText = transform.GetChild(1).gameObject;
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void Infor(string fieldInfor, string benchInfor)
    {
        fieldText.GetComponent<Text>().text = "출전 스킬 : ";
        benchText.GetComponent<Text>().text = "벤치 스킬 : ";

        fieldText.GetComponent<Text>().text += fieldInfor;
        benchText.GetComponent<Text>().text += benchInfor;
    }
}
