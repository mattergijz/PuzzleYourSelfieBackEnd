package PuzzleYourSelfie.backend.GameDiagnostics.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class ToLowerCaseConverter extends StdConverter<String, String> {
    @Override
    public String convert(String value) {
        return value.toLowerCase();
    }
}