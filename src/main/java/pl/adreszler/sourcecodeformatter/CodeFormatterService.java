package pl.adreszler.sourcecodeformatter;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Service;

@Service
class CodeFormatterService {

    private static final Formatter formatter = new Formatter();

    String getFormattedCode(String sourceCode) throws FormatterException {
        return formatter.formatSource(sourceCode);
    }
}
