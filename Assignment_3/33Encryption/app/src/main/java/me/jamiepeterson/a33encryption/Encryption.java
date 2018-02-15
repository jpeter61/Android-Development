package me.jamiepeterson.a33encryption;


public class Encryption {
    public String encrypt(String string, int key){
        String newString = "";
        for(int i = 0; i < string.length(); i++) {
            char next = string.charAt(i);
            //A-Z
            if (next > 64 && next < 91) {
                //convert from ascii
                int value = next-64;
                //encrypt
                value = (value+(key%52))%52;
                //convert back to ascii
                char newChar = convertValue(value);
                newString += newChar;
            }
            //a-z
            else if(next > 97 && next < 123){
                //convert from ascii
                int value = next-71;
                //encrypt
                value = (value+(key%52))%52;
                //convert back to ascii
                char newChar = convertValue(value);
                newString += newChar;
            }
            //other
            else{
                newString += next;
            }
        }
        return newString;
    }

    public String decrypt(String string, int key){
        String newString = "";
        for(int i = 0; i < string.length(); i++) {
            char next = string.charAt(i);
            //A-Z
            if (next > 64 && next < 91) {
                //convert from ascii
                int value = next-64;
                //encrypt
                value = (value-(key%52)+52)%52;
                //convert back to ascii
                char newChar = convertValue(value);
                newString += newChar;
            }
            //a-z
            else if(next > 97 && next < 123){
                //convert from ascii
                int value = next-71;
                //encrypt
                value = (value-(key%52)+52)%52;
                //convert back to ascii
                char newChar = convertValue(value);
                newString += newChar;
            }
            //other
            else{
                newString += next;
            }
        }
        return newString;
    }

    private char convertValue(int value){
        if(value <= 26)
            return (char)(value+64);
        else
            return (char)(value+71);
    }
}
