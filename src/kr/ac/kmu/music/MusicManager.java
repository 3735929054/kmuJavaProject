/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;

import kr.ac.kmu.music.MusicInterface.*;
import java.util.Vector;

public class MusicManager {
    private final Vector<Music> music_data = new Vector<Music>();
    
    public MusicManager()
    {
        
    }
    
    public Music Retrieve(int src_index)
    {
        try
        {
            return music_data.get(src_index);
        }
        catch(ArrayIndexOutOfBoundsException err) {
            return null;
        }
    }
    
    public void Add(Music new_music)
    {
        if(null != new_music) music_data.add(new_music);
    }
    
    public boolean Delete(final int target_index)
    {
        try
        {
            music_data.remove(target_index);
            return true;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            return false;
        }
    }
    
    public boolean Update(int src_index, String artist)
    {
        try
        {
            Music update = music_data.get(src_index);
            update.SetArtist(artist);
            return true;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            return false;
        }
    }
    
    public boolean Update(int src_index, String artist, String album_name)
    {
        try
        {
            Music update = music_data.get(src_index);
            update.SetArtist(artist);
            update.SetAlbumName(album_name);
            return true;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            return false;
        }
    }
    
    public boolean Update(int src_index, Music update_music_data)
    {
        try
        {
            Music update = music_data.get(src_index);
            update.SetArtist(update_music_data.GetArtist());
            update.SetAlbumName(update_music_data.GetAlbumName());
            
            return true;
        }
        catch(ArrayIndexOutOfBoundsException err) {
            return false;
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
        catch(ClassCastException | ArrayIndexOutOfBoundsException err) {
            return false;
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
        catch(ClassCastException | ArrayIndexOutOfBoundsException err) {
            return false;
        }
    }
    
    public int GetCurrentUserCount()
    {
        return music_data.size();
    }
    
    public void SetSortMusicData()
    {
        for(int i = 0; i < music_data.size(); ++i)
        {
            for(int j = 0; j < i; ++j)
            {
                if(music_data.get(i).GetPlayCount() > music_data.get(j).GetPlayCount())
                {
                    Music tmp;
                    tmp = music_data.get(i);
                    music_data.removeElementAt(i);
                    music_data.insertElementAt(tmp, j);
                    break;
                }
            }
        }
    }
}
