package es.urjc.code.daw.library.book;

import org.springframework.stereotype.Service;

@Service
public class LineBreaker {

    public String breakLine(String text, int lineLength){

        if(text.length() <= lineLength){
            return text;
        }

        String[] words = text.split(" ");

        String finalText = "";

        String currentLine = "";

        for (String word: words){

            if(currentLine.length() > lineLength){
                finalText += currentLine.trim() + "\n";
                currentLine = "";
            }

            if(word.length() > lineLength){

                String currentWord = word;

                while(currentWord.length() > lineLength){
                    
                    String slicedWord = currentWord.substring(0, lineLength-1);

                    if( (currentLine + slicedWord).length() <= lineLength){
                        finalText += currentLine.trim() + slicedWord + "-\n";
                    }else{
                        finalText += currentLine.trim() + "\n" + slicedWord + "-\n";
                    }

                    currentWord = currentWord.substring(lineLength-1);
                }

                currentLine = currentWord + "\n";
            
            }else{

                if( (currentLine + word).length() <= lineLength){
                    currentLine += word + " ";
                }else{
                    finalText += currentLine.trim() + "\n";
                    currentLine = word + " ";
                }
            }
            
        }

        finalText += currentLine.trim();

        return finalText;
    }

}