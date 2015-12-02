/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;

public class MusicInterface
{
    public interface MusicBase
    {
        void Play();
        String GetArtist();
        String GetAlbumName();
        int GetPlayCount();
        void SetArtist(String name);
        void SetAlbumName(String name);
    }

    public interface MusicVideo
    {
        void PlayVideo();
    }

    public interface MusicBell
    {
        void PlayBell();
    }
}