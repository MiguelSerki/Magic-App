package App.test;

import javax.swing.text.Document;

import org.jsoup.Jsoup;

public class App 
{
    public static void main( String[] args )
    {
    	Document d = Jsoup.connect ("http://www.mtgmintcard.com/mtg/singles/hou/eng-reg/nicol-bolas-god-pharaoh").timeout(6000).get();
    }
}
