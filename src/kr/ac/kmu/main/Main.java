
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kr.ac.kmu.main;

import java.util.InputMismatchException;
import kr.ac.kmu.music.MusicInterface.*;
import kr.ac.kmu.music.*;
import java.util.Scanner;

public class Main {
    public static void main(String argv[])
    {
        final int Max = 10;
        MusicManager manager = new MusicManager();
        Scanner scanner = new Scanner(System.in);
        
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
            int user;
            try
            {
                user = scanner.nextInt();
            }
            catch(InputMismatchException err) {
                scanner.nextLine();
                continue;
            }
            
            if (user == 1) //Retrieve
            {
                if (manager.GetCurrentUserCount() == 0)
                {
                    System.out.println("등록된 노래가 없습니다.");
                }
                else
                {
                    System.out.println("OST");
                    for(int i = 0; i < manager.GetCurrentUserCount(); ++i)
                    {
                        try
                        {
                            Ost music = (Ost)manager.Retrieve(i);
                            System.out.println((i + 1) + ". 곡이름:" + music.GetAlbumName() + " 가수:" + music.GetArtist() + " 재생수[" + music.GetPlayCount() + "]");
                        }
                        catch(ClassCastException err) {}
                    }
                    
                    System.out.println("HIP POP");
                    for(int i = 0; i < manager.GetCurrentUserCount(); ++i)
                    {
                        try
                        {
                            Hippop music = (Hippop)manager.Retrieve(i);
                            System.out.println((i + 1) + ". 곡이름:" + music.GetAlbumName() + " 가수:" + music.GetArtist() + " 재생수[" + music.GetPlayCount() + "]");
                        }
                        catch(ClassCastException err) {}
                    }
                    
                    System.out.println("Remix");
                    for(int i = 0; i < manager.GetCurrentUserCount(); ++i)
                    {
                        try
                        {
                            Remix music = (Remix)manager.Retrieve(i);
                            System.out.println((i + 1) + ". 곡이름:" + music.GetAlbumName() + " 가수:" + music.GetArtist() + " 재생수[" + music.GetPlayCount() + "]");
                        }
                        catch(ClassCastException err) {}
                    }
                }
            }
            //Add
            else if (user == 2)
            {
                System.out.print("노래 제목을 입력하세요:");
                String album_name = scanner.next();
                System.out.print("아티스트를 입력하세요:");
                String artist = scanner.next();

                System.out.print("노래 종류를 선택하세요: (1)OST (2)Hip-pop (3)Remix");
                int select_music_type;
                try{ select_music_type = scanner.nextInt(); }
                catch(InputMismatchException err) { scanner.nextLine(); continue; }

                Music music;
                switch (select_music_type) {
                    case 1:
                        music = new Ost(artist, album_name);
                        break;
                    case 2:
                        music = new Hippop(artist, album_name);
                        break;
                    case 3:
                        music = new Remix(artist, album_name);
                        break;
                    default:
                        music = null;
                        break;
                }
                try
                {
                    System.out.println("곡명:" + music.GetAlbumName() + " 아티스트:" + music.GetArtist() + " 추가됨.");
                    manager.Add(music);
                }
                catch(NullPointerException err) {
                    System.out.println("잘못된 노래 종류입니다.");
                }
            }
            //Delete
            else if (user == 3)
            {
                int number;
                if(0 == manager.GetCurrentUserCount())
                {
                    System.out.println("등록된 노래가 없습니다.");
                }
                else
                    while (true)
                    {
                        System.out.print("Delete No?");
                        try{ number = scanner.nextInt(); }
                        catch(InputMismatchException err) { scanner.nextLine(); continue; }

                        if (manager.Delete(number - 1))
                        {
                            System.out.println("해당 노래가 없습니다.");
                        }
                        else {
                            break;
                        }
                    }
            }
            //Update
            else if (4 == user)
            {
                int number;
                if(0 == manager.GetCurrentUserCount())
                {
                    System.out.println("등록된 노래가 없습니다.");
                }
                else
                    while (true)
                    {
                        System.out.print("Update No?");
                        try{ number = scanner.nextInt(); }
                        catch(InputMismatchException err) { scanner.nextLine(); continue; }

                        if (number > manager.GetCurrentUserCount() || number <= 0)
                        {
                            System.out.println("해당 노래가 없습니다.");
                            continue;
                        }
                        else {
                            System.out.print("변경될 곡명을 입력하세요:");
                            String album_name = scanner.next();
                            System.out.print("변경될 아티스트를 입력하세요:");
                            String artist = scanner.next();

                            manager.Update(number - 1, artist, album_name);
                            System.out.println(number + ".곡명:" + album_name + " 아티스트:" + artist + " 변경됨.");

                            break;
                        }
                    }
            }
            //Player
            else if (user == 5)
            {
                if (0 != manager.GetCurrentUserCount())
                {
                    while (true)
                    {
                        System.out.print("Music No?");
                        int number;
                        try{ number = scanner.nextInt(); }
                        catch(InputMismatchException err) { scanner.nextLine(); continue; }

                        if (number > manager.GetCurrentUserCount() || number <= 0)
                        {
                            System.out.println("해당 노래가 없습니다.");
                        }
                        else {
                            System.out.print("Play type (1) Music (2) Music video (3) Music Bell? ");
                            int option;
                            try{ option = scanner.nextInt(); }
                            catch(InputMismatchException err) { scanner.nextLine(); continue; }
                            
                            switch(option)
                            {
                                case 1:
                                    if(!manager.PlayMusic(number - 1))
                                        System.out.println("지원하지 않는 기능입니다.");
                                    break;
                                case 2:
                                    if(!manager.PlayMusicVideo(number - 1))
                                        System.out.println("지원하지 않는 기능입니다.");
                                    break;
                                case 3:
                                    if(!manager.PlayMusicBell(number - 1))
                                        System.out.println("지원하지 않는 기능입니다.");
                                    break;
                                default:
                                    System.out.println("지원하지 않는 기능입니다.");
                            }
                            break;
                        }
                    }
                }
                else System.out.println("등록된 노래가 없습니다.");
            }
            //Quit
            else if (user == 6) 
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
