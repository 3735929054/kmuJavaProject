
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kr.ac.kmu.main;
import kr.ac.kmu.music.*;
import java.util.Scanner;

public class Main {
    public static void main(String argv[])
    {
        MusicManager manager = new MusicManager();
        Scanner scanner = new Scanner(System.in);
        Music m;
        
        final int Max = 10;

        while (true)
        {
            System.out.println("*************************");
            System.out.println("1.Retrieve(노래 조회)");
            System.out.println("2.Add(노래 추가)");
            System.out.println("3.Delete(노래 삭제)");
            System.out.println("4.Update(노래 수정)");
            System.out.println("5.Player(노래 재생)");
            System.out.println("6.Quit(나가기)");
            System.out.println("*************************");
            System.out.print(">");

            int user = scanner.nextInt();
            if (user == 1) //Retrieve
            {
                if (manager.GetCurrentUserCount() == 0)
                {
                    System.out.println("등록된 노래가 없습니다.");
                }

                else
                {
                    Music music;
                    //print
                    for (int i = 0; i < manager.GetCurrentUserCount(); i++)
                    {
                        music = manager.Retrieve(i);
                        System.out.println((i + 1) + ".곡명:" + music.GetAlbumName() + " 아티스트:" + music.GetArtist() + " 재생 수:" + music.GetPlayCount());
                    }
                }
            }

            else if (user == 2) //Add
            {
                if (manager.GetCurrentUserCount() == Max)
                    System.out.println("더이상 입력할 수 없습니다!!");
                else
                {
                    System.out.print("노래 종류를 선택하세요: (1)OST (2)Hip-pop (3)Remix");
                    int select_music_type = scanner.nextInt();
                    switch(select_music_type)
                    {
                        case 2: 
                    }
                    switch()
                    System.out.print("노래 제목을 입력하세요:");
                    music._subject = scanner.next();
                    System.out.print("아티스트를 입력하세요:");
                    music._artist = scanner.next();

                    manager.Add(music);
                    System.out.println("곡명:" + music._subject + " 아티스트:" + music._artist + " 추가됨.");
                }
            }

            else if (user == 3) //Delete
            {
                int number = 0;

                while (true)
                {
                    System.out.print("Delete No?");
                    number = scanner.nextInt();
                    number--;

                    if (number + 1 < 1 || number + 1 > manager.GetCurrentUserCount())
                    {
                        System.out.println("해당 노래가 없습니다.");
                    }

                    else
                    {
                        manager.Delete(number);
                        break;
                    }
                }
            }

            else if (user == 4) //Update
            {
                MusicInfo music = new MusicInfo();
                int number = 0;

                while (true)
                {
                    System.out.print("Update No?");
                    number = scanner.nextInt();

                    if (number > manager.GetCurrentUserCount() || number <= 0)
                    {
                        System.out.println("해당 노래가 없습니다.");
                    }

                    else
                    {

                        System.out.print("변경될 곡명을 입력하세요:");
                        music._subject = scanner.next();
                        System.out.print("변경될 아티스트를 입력하세요:");
                        music._artist = scanner.next();

                        manager.Update(number, music);
                        System.out.println(number + ".곡명:" + music._subject + " 아티스트:" + music._artist + " 변경됨.");

                        break;
                    }
                }
            }

            else if (user == 5) //Player
            {
                if (0 != manager.GetCurrentUserCount())
                {
                    while (true)
                    {
                        System.out.print("Music No?");
                        int number = scanner.nextInt();

                        if (number > manager.GetCurrentUserCount() || number <= 0)
                        {
                            System.out.println("해당 노래가 없습니다.");
                        }

                        else
                        {
                            manager.playMusic(number - 1);
                            break;
                        }
                    }
                }
                else
                    System.out.println("등록된 노래가 없습니다.");
            }

            else if (user == 6) //Quit
            {
                System.out.println("Bye");
                break;
            }

            else
            {
                System.out.println("해당 메뉴가 없습니다!!");
            }
        }
        scanner.close();
    }
}
