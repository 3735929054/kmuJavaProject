/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;

import kr.ac.kmu.music.MusicInterface.*;
import java.util.Vector;
/**
 *
 * @author imgomi
 */
public class MusicManager {
    private final int MAX_MUSIC_DATA_NUM;
    private Vector<Music> music_data = new Vector<Music>();
    private int user_count = 0;
    
    public MusicManager()
    {
        MAX_MUSIC_DATA_NUM = 10;
    }
    
    public MusicManager(int allow_size)
    {
        MAX_MUSIC_DATA_NUM = allow_size;
    }
    
    public Music Retrieve(int src_index)
    {
        try
        {
            return music_data.get(src_index);
        }
        catch(ArrayIndexOutOfBoundsException err) {
            return new Ost(); // Default music type
        }
    }
    
    public void Add(Music new_music)
    {
            music_data.add(new_music);
            ++user_count;
    }
    
    public void Delete(final int target_index)
    {
        try
        {
            music_data.remove(target_index);
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
            Music update = music_data.get(src_index);
            update.SetArtist(artist);
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
            Music update = music_data.get(src_index);
            update.SetArtist(artist);
            update.SetAlbumName(album_name);
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
            Music update = music_data.get(src_index);
            update.SetArtist(update_music_data.GetArtist());
            update.SetAlbumName(update_music_data.GetAlbumName());
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
            music_data.get(music_num).PlayMusic();
            return true;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            return false;
        }
    }
    
    public boolean PlayMusicVideo(int music_num)
    {
        try
        {
            MusicVideo mv = (MusicVideo)music_data.get(music_num);
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
            MusicBell mb = (MusicBell)music_data.get(music_num);
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
