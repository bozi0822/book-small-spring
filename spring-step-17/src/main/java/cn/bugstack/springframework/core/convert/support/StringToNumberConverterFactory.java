package cn.bugstack.springframework.core.convert.support;

import cn.bugstack.springframework.core.convert.converter.Converter;
import cn.bugstack.springframework.core.convert.converter.ConverterFactory;
import cn.bugstack.springframework.util.NumberUtils;
import com.sun.istack.internal.Nullable;

/**
 * @author 小傅哥，微信：fustack
 *
 * 来自于对开源项目的学习；
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description Converts from a String any JDK-standard Number implementation.
 * @date 2022/3/16
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {

    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        @Nullable
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }

}
