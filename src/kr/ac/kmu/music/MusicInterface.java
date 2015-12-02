/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;

public class MusicInterface
{
    public interface Music
    {
        public int GetPlayCount();
        
        public String GetArtist();
        public String GetAlbumName();
        
        public void PlayMusic();
        public void SetArtist(String name);
        public void SetAlbumName(String name);
    }

    public interface MusicVideo
    {
        public void PlayVideo();
    }

    public interface MusicBell
    {
        public void PlayBell();
    }
}