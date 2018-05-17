package shaohua.study.web;

import org.springframework.core.convert.converter.Converter;
/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/25 17:42
 */
public class StringTrimer implements Converter<String,String> {
    @Override
    public String convert(String s) {
        return s == null ? s : s.trim();
    }
}
