/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;

interface MusicBase
{
    void Play();
    String GetArtist();
    int GetPlayCount();
    void SetArtist(String name);
}

interface MusicVideo
{
    void PlayVideo();
}

interface MusicBell
{
    void PlayBell();
}