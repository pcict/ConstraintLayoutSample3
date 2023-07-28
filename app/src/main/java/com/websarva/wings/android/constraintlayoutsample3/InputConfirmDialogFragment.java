package com.websarva.wings.android.constraintlayoutsample3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class InputConfirmDialogFragment extends DialogFragment{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        //追加
        Bundle extras = this.getArguments();
        String etName = "";
        String etMail = "";
        String etComment = "";

        if(extras != null){
            etName = extras.getString("etName");
            etMail = extras.getString("etMail");
            etComment = extras.getString("etComment");
        }

        //ダイアログ作成を支援してくれるビルダーを準備
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログタイトルの設定
        builder.setTitle(R.string.dialog_title);
        //ダイアログメッセージ
        builder.setMessage("名前: " + etName + "\nメールアドレス: " + etMail + "\n質問内容: " + etComment);
        //ボタンの準備
        //第一引数：表示したい文字　第二引数：イベントリスナー
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        //ダイアログの作成
        AlertDialog dialog = builder.create();

        //作成したダイアログを戻り値とする
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String msg = "";

            if(which == DialogInterface.BUTTON_POSITIVE){

            }
//            //トーストの準備
//            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
