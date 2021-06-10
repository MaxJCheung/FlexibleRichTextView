package com.daquexian.flexiblerichtextview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;

import org.scilab.forge.jlatexmath.core.AjLatexMath;
import org.scilab.forge.jlatexmath.core.Insets;
import org.scilab.forge.jlatexmath.core.TeXConstants;
import org.scilab.forge.jlatexmath.core.TeXFormula;
import org.scilab.forge.jlatexmath.core.TeXIcon;

import java.util.List;

/**
 * Created by daquexian on 17-2-16.
 */

public class LaTeXtView extends TextView {

    public interface OnFormulaParsedListener {
        void onFormulaParsed(@NonNull SpannableStringBuilder builder);
    }

    private OnFormulaParsedListener onFormulaParsedListener = null;

    public void setOnFormulaParsedListener(OnFormulaParsedListener onFormulaParsedListener) {
        this.onFormulaParsedListener = onFormulaParsedListener;
    }

    public LaTeXtView(Context context) {
        super(context);
    }

//    public void changeTextColor(){
//         SpannableStringBuilder builder= (SpannableStringBuilder) getText();
//        builder.
//    }

    public void setTextWithFormula(TextWithFormula textWithFormula) {
        List<TextWithFormula.Formula> formulas = textWithFormula.getFormulas();
        final SpannableStringBuilder builder = textWithFormula;
        for (final TextWithFormula.Formula formula : formulas) {
            TeXFormula teXFormula = TeXFormula.getPartialTeXFormula(formula.content);
            try {
                Bitmap bitmap = getBitmap(teXFormula);
                if (bitmap.getWidth() > FlexibleRichTextView.MAX_IMAGE_WIDTH) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, FlexibleRichTextView.MAX_IMAGE_WIDTH,
                            bitmap.getHeight() * FlexibleRichTextView.MAX_IMAGE_WIDTH / bitmap.getWidth(),
                            false);
                }

                builder.setSpan(new CenteredImageSpan(getContext(), bitmap),
                        formula.start, formula.end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            } catch (Exception e) {
            }
        }
        if (onFormulaParsedListener != null) {
            onFormulaParsedListener.onFormulaParsed(builder);
        }
        setText(builder);
    }

    private Bitmap getBitmap(TeXFormula formula) {
        TeXIcon icon = formula.new TeXIconBuilder()
                .setStyle(TeXConstants.STYLE_DISPLAY)
                .setFGColor(getPaint().getColor())
                .setSize(SizeUtil.px2sp(getPaint().getTextSize()))
                .setWidth(TeXConstants.UNIT_SP, getPaint().getTextSize() / getPaint().density, TeXConstants.ALIGN_LEFT)
                .setIsMaxWidth(true)
                .setInterLineSpacing(TeXConstants.UNIT_SP,
                        AjLatexMath.getLeading(getPaint().getTextSize() / getPaint().density))
                .build();
        icon.setInsets(new Insets(5, 5, 5, 5));

        Bitmap image = Bitmap.createBitmap(icon.getIconWidth(), icon.getIconHeight(),
                Bitmap.Config.ARGB_4444);

        Canvas g2 = new Canvas(image);
        g2.drawColor(Color.TRANSPARENT);
        icon.paintIcon(g2, 0, 0);
        return image;
    }
}
