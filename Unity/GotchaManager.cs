using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class GotchaManager : MonoBehaviour
{
    public int searchTicket = 0;
    public GameObject ticket;

    public CardSettings[] cardList;
    public RaycastHit2D hit;

    public int maxCard = 5;
    // Start is called before the first frame update
    void Start()
    {
        Debug.Log(SceneManager.GetActiveScene().name);
        TicketGive(SceneManager.GetActiveScene().name);
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            Vector2 pos = Camera.main.ScreenToWorldPoint(Input.mousePosition);
            hit = Physics2D.Raycast(pos, Vector2.zero, 0f);

            if (hit.collider != null)
            {
                Debug.Log(hit.collider.GetComponent<ThisCard>().id);
                for (int i = 0; i < cardList.Length; i++)
                {
                    if (hit.collider.gameObject.GetComponent<ThisCard>().id == cardList[i].GetComponent<ThisCard>().id)
                    {

                    }
                    else
                    {
                        cardList[i].GetComponent<CardSettings>().choiceImage.SetActive(false);
                    }
                }
            }
        }
        //ticket.GetComponent<Text>().text = "Ticket : " + searchTicket;

    }
    public void CardPull()
    {
        searchTicket--;
    }
    public void TicketGive(string sceneName)
    {
        switch (sceneName)
        {
            case "Chapter_1":
                searchTicket += 2;
                break;

            case "Chapter_2":
                searchTicket++;
                break;

            case "Chapter_3":
                searchTicket++;
                break;

            case "Chapter_4":
                searchTicket++;
                break;

            case "Chapter_5":
                searchTicket++;
                break;

            case "Chapter_6":
                searchTicket++;
                break;
        }
    }

    public void reroll()
    {
        int[] list = new int[maxCard];
        for (int i = 0; i < maxCard; i++)
        {
            list[i] = Random.Range(0, maxCard);
            for (int j = 0; j < i; j++)
            {
                if (list[i] == list[j])
                {
                    i--;
                    break;
                }
            }
        }
        for(int i = 0; i < maxCard; i++)
        cardList[i].GetComponent<ThisCard>().thisId = list[i];
    }

    private void OnEnable()
    {
        cardList = FindObjectsOfType<CardSettings>();
        reroll();
    }

    //public void Rand()
    //{ 중복제거 기초
    //    int[] list = new int[maxCard];
    //    for (int i = 0; i < maxCard; i++)
    //    {
    //        list[i] = Random.Range(0, maxCard);
    //        for (int j = 0; j < i; j++)
    //        {
    //            if (list[i] == list[j])
    //            {
    //                i--;
    //                break;
    //            }
    //        }
    //    }
    //}
}
