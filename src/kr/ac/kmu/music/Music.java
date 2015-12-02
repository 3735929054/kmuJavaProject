/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.ac.kmu.music;

public class Music 
    implements MusicBase
{
    @Override
    public void Play()
    {
        return;
    }
    
    @Override
    public String GetArtist()
    {
        return "Unknown";
    }
    
    @Override
    public int GetPlayCount()
    {
        return 0;
    }
    
    @Override
    public void SetArtist(String name)
    {
        return;
    }
}