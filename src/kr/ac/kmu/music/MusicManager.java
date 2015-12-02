/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;

import kr.ac.kmu.music.MusicInterface.*;

/**
 *
 * @author imgomi
 */
public class MusicManager {
    private final int MAX_MUSIC_DATA_NUM;
    private Music[] music_data;
    private int user_count = 0;
    
    public MusicManager()
    {
        MAX_MUSIC_DATA_NUM = 10;
        music_data = new Music[MAX_MUSIC_DATA_NUM];
    }
    
    public MusicManager(int allow_size)
    {
        MAX_MUSIC_DATA_NUM = allow_size;
        music_data = new Music[MAX_MUSIC_DATA_NUM];
    }
    
    public Music Retrieve(int src_index)
    {
        return music_data[src_index];
    }
    
    public void Add(Music new_music)
    {
        try
        {
            music_data[user_count] = new_music;
            ++user_count;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public void Delete(final int target_index)
    {
        try
        {
            for(int i = target_index; i < user_count; ++i)
            {
                music_data[i] = music_data[i + 1];
            }
            --user_count;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch(NullPointerException err) {
            throw new NullPointerException();
        }
    }
    
    public void Update(int src_index, String artist)
    {
        try
        {
            music_data[src_index].SetArtist(artist);
        }
        catch(ArrayIndexOutOfBoundsException err) {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch(NullPointerException err) {
            throw new NullPointerException();
        }
    }
    
    public void Update(int src_index, String artist, String album_name)
    {
        try
        {
            music_data[src_index].SetArtist(artist);
            music_data[src_index].SetAlbumName(album_name);
        }
        catch(ArrayIndexOutOfBoundsException err) {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch(NullPointerException err) {
            throw new NullPointerException();
        }
    }
    
    public void Update(int src_index, Music update_music_data)
    {
        try
        {
            music_data[src_index] = update_music_data;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch(NullPointerException err) {
            throw new NullPointerException();
        }
    }
    
    public boolean PlayMusic(int music_num)
    {
        try
        {
            music_data[music_num].PlayMusic();
            return true;
        }
        catch(ClassCastException err) {
            return false;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public boolean PlayMusicVideo(int music_num)
    {
        try
        {
            MusicVideo mv = (MusicVideo)music_data[music_num];
            mv.PlayVideo();
            return true;
        }
        catch(ClassCastException err) {
            return false;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public boolean PlayMusicBell(int music_num)
    {
        try
        {
            MusicBell mb = (MusicBell)music_data[music_num];
            mb.PlayBell();
            return true;
        }
        catch(ClassCastException err) {
            return false;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public int GetCurrentUserCount()
    {
        return user_count;
    }
}
