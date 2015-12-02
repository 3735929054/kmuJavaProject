/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;
import java.util.HashSet;
import java.util.Set;
import kr.ac.kmu.*;

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
        for(int i = 0; i < MAX_MUSIC_DATA_NUM; ++i)
            music_data[i] = new Music();
    }
    
    public MusicManager(int allow_size)
    {
        MAX_MUSIC_DATA_NUM = allow_size;
        music_data = new Music[MAX_MUSIC_DATA_NUM];
        for(int i = 0; i < MAX_MUSIC_DATA_NUM; ++i)
            music_data[i] = new Music();
    }
    
    public Music Retrieve(int src_index) throws ArrayIndexOutOfBoundsException
    {
        return music_data[src_index];
    }
    
    public void Add(Music new_music)
    {
        try
        {
            music_data[user_count] = new_music;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public void Delete(final int target_index)
    {
        try
        {
            for(int i = target_index; i < MAX_MUSIC_DATA_NUM; ++i)
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
    
    public int GetCurrentUserCount()
    {
        return user_count;
    }
}
