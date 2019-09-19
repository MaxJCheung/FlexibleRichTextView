package com.daquexian.flexiblerichtextview;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.util.Log;
import android.widget.TextView;

/**
 * Create by cuizhen on {2019/9/19}
 *
 * ▄████▄   █    ██  ██▓▒███████▒ ██░ ██ ▓█████ ███▄    █
 * ▒██▀ ▀█   ██  ▓██▒▓██▒▒ ▒ ▒ ▄▀░▓██░ ██▒▓█   ▀ ██ ▀█   █
 * ▒▓█    ▄ ▓██  ▒██░▒██▒░ ▒ ▄▀▒░ ▒██▀▀██░▒███  ▓██  ▀█ ██▒
 * ▒▓▓▄ ▄██▒▓▓█  ░██░░██░  ▄▀▒   ░░▓█ ░██ ▒▓█  ▄▓██▒  ▐▌██▒
 * ▒ ▓███▀ ░▒▒█████▓ ░██░▒███████▒░▓█▒░██▓░▒████▒██░   ▓██░
 * ░ ░▒ ▒  ░░▒▓▒ ▒ ▒ ░▓  ░▒▒ ▓░▒░▒ ▒ ░░▒░▒░░ ▒░ ░ ▒░   ▒ ▒
 * ░  ▒   ░░▒░ ░ ░  ▒ ░░░▒ ▒ ░ ▒ ▒ ░▒░ ░ ░ ░  ░ ░░   ░ ▒░
 * ░         ░░░ ░ ░  ▒ ░░ ░ ░ ░ ░ ░  ░░ ░   ░     ░   ░ ░
 * ░ ░         ░      ░    ░ ░     ░  ░  ░   ░  ░        ░
 * ░                     ░
 */
class TextViewLinesUtil {
    static int getTextViewLines(TextView textView, int textViewWidth) {
        int width = textViewWidth - textView.getCompoundPaddingLeft() - textView.getCompoundPaddingRight();
        Log.i("TextViewLinesUtil", "textViewWidth=" + textViewWidth);
        Log.i("TextViewLinesUtil", "textView.getText()=" + textView.getText());
        StaticLayout staticLayout;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            staticLayout = getStaticLayout23(textView, width);
        } else {
            staticLayout = getStaticLayout(textView, width);
        }
        int lines = staticLayout.getLineCount();
        Log.i("TextViewLinesUtil", "lines=" + lines);
        int maxLines = textView.getMaxLines();
        if (maxLines > lines) {
            return lines;
        }
        Log.i("TextViewLinesUtil", "maxLines=" + maxLines);
        return maxLines;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private static StaticLayout getStaticLayout23(TextView textView, int width) {
        StaticLayout.Builder builder = StaticLayout.Builder.obtain(textView.getText(),
                0, textView.getText().length(), textView.getPaint(), width)
                .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                .setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR)
                .setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier())
                .setIncludePad(textView.getIncludeFontPadding())
                .setBreakStrategy(textView.getBreakStrategy())
                .setHyphenationFrequency(textView.getHyphenationFrequency())
                .setMaxLines(textView.getMaxLines() == -1 ? Integer.MAX_VALUE : textView.getMaxLines());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setJustificationMode(textView.getJustificationMode());
        }
        if (textView.getEllipsize() != null && textView.getKeyListener() == null) {
            builder.setEllipsize(textView.getEllipsize())
                    .setEllipsizedWidth(width);
        }
        return builder.build();
    }

    private static StaticLayout getStaticLayout(TextView textView, int width) {
        return new StaticLayout(textView.getText(),
                0, textView.getText().length(),
                textView.getPaint(), width, Layout.Alignment.ALIGN_NORMAL,
                textView.getLineSpacingMultiplier(),
                textView.getLineSpacingExtra(), textView.getIncludeFontPadding(), textView.getEllipsize(),
                width);
    }
}
