package pl.adreszler.sourcecodeformatter;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class CodeFormatterService {

    private static final Formatter formatter = new Formatter();

    Optional<String> getFormattedCode(String sourceCode) {
        try {
            return Optional.of(formatter.formatSource(sourceCode));
        } catch (FormatterException e) {
            return Optional.empty();
        }
    }
}
