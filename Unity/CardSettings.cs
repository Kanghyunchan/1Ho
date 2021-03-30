using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;

public class CardSettings : MonoBehaviour
{
    public GameObject choiceImage;
    public bool poolToken = false;
    public bool select = false;
    public GameObject gotchaManager;

    float time = 0;
    bool delay = false;
    public int clickCnt = 2;

    // Start is called before the first frame update
    void Start()
    {
        gotchaManager = GameObject.Find("GotchaManager");
    }

    // Update is called once per frame
    void Update()
    {
        if (delay)
        {
            time += Time.deltaTime;
        }
    }
    public void OnMouseDown()
    {
        if (poolToken)
        {
            choiceImage.SetActive(true);
            clickCnt--;
            if (clickCnt == 1)
            {
                time = 0.0f;
                delay = true;
            }
            if (clickCnt == 0 && time <= 0.5f)
            {
                choiceImage.SetActive(false);
                Debug.Log("뽑으시겠습니까?");
                StopCoroutine("Pulling");
                clickCnt = 2;
            }
            else
            {
                StartCoroutine("Pulling");
            }
        }
    }
    IEnumerator Pulling()
    {
        yield return new WaitForSecondsRealtime(0.5f);
        //choiceImage.SetActive(false);
        delay = false;
        clickCnt = 2;
    }

}
