package com.example.smartpilow;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.ktx.AuthKt;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 6, 0},
        k = 1,
        d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"},
        d2 = {"Lcom/example/smartpilow/FirstFragment;", "Landroidx/fragment/app/Fragment;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "signIn", "email", "", "password", "SmartPilow.app.main"}
)
public final class FirstFragmentJava extends Fragment {
    private FirebaseAuth auth;

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.auth = AuthKt.getAuth(Firebase.INSTANCE);
        return inflater.inflate(1300035, container, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final EditText editTextEmail = (EditText)view.findViewById(1000405);
        final EditText editTextPassword = (EditText)view.findViewById(1000282);
        ((Button)view.findViewById(1000353)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                EditText var10000 = editTextEmail;
                Intrinsics.checkNotNullExpressionValue(var10000, "editTextEmail");
                Editable var3 = var10000.getText();
                Intrinsics.checkNotNullExpressionValue(var3, "editTextEmail.text");
                CharSequence var2 = (CharSequence)var3;
                if (var2.length() != 0) {
                    var10000 = editTextPassword;
                    Intrinsics.checkNotNullExpressionValue(var10000, "editTextPassword");
                    var3 = var10000.getText();
                    Intrinsics.checkNotNullExpressionValue(var3, "editTextPassword.text");
                    var2 = (CharSequence)var3;
                    if (var2.length() != 0) {
                        FirstFragmentJava var4 = FirstFragmentJava.this;
                        EditText var10001 = editTextEmail;
                        Intrinsics.checkNotNullExpressionValue(var10001, "editTextEmail");
                        String var5 = var10001.getText().toString();
                        EditText var10002 = editTextPassword;
                        Intrinsics.checkNotNullExpressionValue(var10002, "editTextPassword");
                        var4.signIn(var5, var10002.getText().toString());
                        return;
                    }
                }

                Toast.makeText(FirstFragmentJava.this.getContext(), (CharSequence)"Enter email or password", 1).show();
            }
        }));
    }

    private final void signIn(String email, String password) {
        FirebaseAuth var10000 = this.auth;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        }

        var10000.signInWithEmailAndPassword(email, password).addOnCompleteListener((OnCompleteListener)(new OnCompleteListener() {
            public final void onComplete(@NotNull Task task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.isSuccessful()) {
                    FirebaseUser user = FirstFragmentJava.access$getAuth$p(FirstFragmentJava.this).getCurrentUser();
                    if (user != null) {
                        if (Intrinsics.areEqual(user.getEmail(), "test1@gmail.com")) {
                            FragmentKt.findNavController(FirstFragmentJava.this).navigate(1000396);
                        } else {
                            FragmentKt.findNavController(FirstFragmentJava.this).navigate(1000255);
                        }
                    }
                } else {
                    Toast.makeText(FirstFragmentJava.this.getContext(), (CharSequence)"Authentication failed.", 1).show();
                }

            }
        }));
    }

    // $FF: synthetic method
    public static final FirebaseAuth access$getAuth$p(FirstFragmentJava $this) {
        FirebaseAuth var10000 = $this.auth;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setAuth$p(FirstFragmentJava $this, FirebaseAuth var1) {
        $this.auth = var1;
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }
}
