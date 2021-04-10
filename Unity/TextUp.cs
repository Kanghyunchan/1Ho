using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class TextUp : MonoBehaviour
{
    public float speed = 0.001f;
    private RectTransform rect;
    // Start is called before the first frame update
    void Start()
    {
        rect = GetComponent<RectTransform>();
    }

    // Update is called once per frame
    void Update()
    {
        Vector3 pos = transform.position;
        pos.y += speed;
        rect.position = pos;
        Debug.Log(rect.position.y);
        if(rect.position.y >= 800f)
        {
            SceneManager.LoadScene("MainMenu");
        }
    }
}
