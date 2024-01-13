package Lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class LinksToHyperlinks {

    public static void main(String[] args) {
        try {
            Pattern LinkToHyperlinkPattern = Pattern.compile("(^|\\s)(www\\.)?(\\w{0,})(\\.)(\\S{3}|\\S{2})");

            String textWithHttpLinksEnabled =
                    "taiti.com Welcome to our sberbank.ru our Tel: 8-800-555-3535 our site : https://www.sberbank.ru and our mail is sberbank@mail.ru whatsup.com kom.tom htqp://whyyyyyy.com ";

            Matcher LinkToHyperlinkMatcher = LinkToHyperlinkPattern.matcher(textWithHttpLinksEnabled);
            while (LinkToHyperlinkMatcher.find()) {
                String Placeholder = LinkToHyperlinkMatcher.group();
                Pattern exactlyWhatToReplace = Pattern.compile(Placeholder);
                Matcher ReplaceOnly = exactlyWhatToReplace.matcher(textWithHttpLinksEnabled);
                Placeholder = Placeholder.replaceAll(" ","");
                textWithHttpLinksEnabled = ReplaceOnly.replaceAll(" https://" + Placeholder);
            }

            System.out.println(textWithHttpLinksEnabled);
        } catch (PatternSyntaxException e){System.out.println(e);return;}
        }
}

// https://regex101.com/r/9bThuo/1
// https://regex101.com/r/Ilx9Kv/1 - I ended up using one of these
// https://regex101.com/r/4gqPVg/1
// https://regex101.com/r/v5qXMX/1