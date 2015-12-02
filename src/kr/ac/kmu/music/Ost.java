/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;

public class Ost
    implements MusicBase, MusicVideo, MusicBell
{
    private int play_count;
    private String artist;
    private String album_name;
    
    public Ost()
    {
        artist = "Unknown";
        album_name = "Unknown";
        play_count = 0;
    }
    
    public Ost(String arg_artist, String arg_album_name)
    {
        artist = arg_artist;
        album_name = arg_album_name;
        play_count = 0;
    }
    
    @Override
    public void Play()
    {
        play_count++;
    }
    
    @Override
    public void PlayVideo()
    {
        play_count++;
    }
    
    @Override
    public void PlayBell()
    {
        play_count++;
    }
    
    @Override
    public String GetArtist()
    {
        return artist;
    }
    
    @Override
    public String GetAlbumName()
    {
        return album_name;
    }
    
    @Override
    public int GetPlayCount()
    {
        return play_count;
    }
    
    @Override
    public void SetArtist(String name)
    {
        artist = name;
    }
    
    @Override
    public void SetAlbumName(String name)
    {
        album_name = name;
    }
}
