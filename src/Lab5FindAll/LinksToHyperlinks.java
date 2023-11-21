package Lab5FindAll;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksToHyperlinks {

    public static void main(String[] args) {
        Pattern LinkToHyperlinkPattern = Pattern.compile("(\\s)(www\\.)?(\\w{0,})(\\.)(\\S{3}|\\S{2})(\\s|\\/|\\n|$)");

        //Pattern httpLinkPattern = Pattern.compile("(http[s]?)://(www\\.)?([\\S&&[^.@]]+)(\\.[\\S&&[^@]]+)");

        //Pattern mailAddressPattern = Pattern.compile("[\\S&&[^@]]+@([\\S&&[^.@]]+)(\\.[\\S&&[^@]]+)");

        //Pattern telephoneNumber = Pattern.compile("\\d{11}|(?:\\d{1}-)(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");

        String textWithHttpLinksEnabled =
                "Welcome to our sberbank.ru our Tel: 8-800-555-3535 our site : https://www.sberbank.ru and our mail is sberbank@mail.ru whatsup.com";

        //Matcher mailLinksMatcher = mailAddressPattern.matcher(textWithHttpLinksEnabled);
        //textWithHttpLinksEnabled = mailLinksMatcher.replaceAll("<a href=\"mailto:$0\">$0</a>");

            Matcher LinkToHyperlinkMatcher = LinkToHyperlinkPattern.matcher(textWithHttpLinksEnabled);
            while (LinkToHyperlinkMatcher.find()) {
                String Placeholder = LinkToHyperlinkMatcher.group();
                    Pattern exactlyWhatToReplace = Pattern.compile(Placeholder);
                    Matcher ReplaceOnly = exactlyWhatToReplace.matcher(textWithHttpLinksEnabled);
                    Placeholder = Placeholder.substring(1);
                    textWithHttpLinksEnabled = ReplaceOnly.replaceAll(" https://"+Placeholder);
            }

            //Matcher httpLinksMatcher = httpLinkPattern.matcher(textWithHttpLinksEnabled);
            //textWithHttpLinksEnabled = httpLinksMatcher.replaceAll("<a href=\"$0\" target=\"_blank\">$0</a>");

            //Matcher phoneNumberMatcher = telephoneNumber.matcher(textWithHttpLinksEnabled);
            //textWithHttpLinksEnabled = phoneNumberMatcher.replaceAll("<a href=\"$0\"> $0");

            System.out.println(textWithHttpLinksEnabled);
    }
}

// https://regex101.com/r/9bThuo/1
// https://regex101.com/r/Ilx9Kv/1 - I ended up using one of these
// https://regex101.com/r/4gqPVg/1
// https://regex101.com/r/v5qXMX/1