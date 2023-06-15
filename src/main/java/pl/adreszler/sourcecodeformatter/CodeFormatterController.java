package pl.adreszler.sourcecodeformatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
class CodeFormatterController {

    private final CodeFormatterService codeFormatterService;

    public CodeFormatterController(CodeFormatterService codeFormatterService) {
        this.codeFormatterService = codeFormatterService;
    }

    @PostMapping("/format")
    String format(@RequestParam String code, Model model) {
        Optional<String> formattedCode = codeFormatterService.getFormattedCode(code);

        if (formattedCode.isEmpty()) {
            return "error";
        }

        model.addAttribute("codeBefore", code);
        model.addAttribute("codeAfter", formattedCode.get());
        return "success";
    }
}
