/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;

public class Remix
    implements MusicBase, MusicBell
{
    private int play_count;
    private String artist;
    
    Remix()
    {
        artist = "Unknown";
        play_count = 0;
    }
    
    Remix(String arg_artist)
    {
        artist = arg_artist;
        play_count = 0;
    }
    
    @Override
    public void Play()
    {
        play_count++;
    }
    
    @Override
    public String GetArtist()
    {
        return artist;
    }
    
    @Override
    public int GetPlayCount()
    {
        return play_count;
    }
    
    @Override
    public void PlayBell()
    {
        play_count++;
    }
    
    @Override
    public void SetArtist(String name)
    {
        artist = name;
    }
}
