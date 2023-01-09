// EmptyFragment.java
package com.example.smartpilow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 6, 0},
        k = 1,
        d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"},
        d2 = {"Lcom/example/smartpilow/EmptyFragment;", "Landroidx/fragment/app/Fragment;", "()V", "param1", "", "param2", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "SmartPilow.app.main"}
)
public final class EmptyFragmentJava extends Fragment {
    private String param1;
    private String param2;
    @NotNull
    public static final EmptyFragmentJava.Companion Companion = new EmptyFragmentJava.Companion((DefaultConstructorMarker)null);

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle var10000 = this.getArguments();
        if (var10000 != null) {
            Bundle var2 = var10000;
            int var4 = false;
            this.param1 = var2.getString("param1");
            this.param2 = var2.getString("param2");
        }

    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(1300096, container, false);
    }

    @JvmStatic
    @NotNull
    public static final EmptyFragmentJava newInstance(@NotNull String param1, @NotNull String param2) {
        return Companion.newInstance(param1, param2);
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }

    @Metadata(
            mv = {1, 6, 0},
            k = 1,
            d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"},
            d2 = {"Lcom/example/smartpilow/EmptyFragment$Companion;", "", "()V", "newInstance", "Lcom/example/smartpilow/EmptyFragment;", "param1", "", "param2", "SmartPilow.app.main"}
    )
    public static final class Companion {
        @JvmStatic
        @NotNull
        public final EmptyFragmentJava newInstance(@NotNull String param1, @NotNull String param2) {
            Intrinsics.checkNotNullParameter(param1, "param1");
            Intrinsics.checkNotNullParameter(param2, "param2");
            EmptyFragmentJava var3 = new EmptyFragmentJava();
            int var5 = false;
            Bundle var6 = new Bundle();
            int var9 = false;
            var6.putString("param1", param1);
            var6.putString("param2", param2);
            Unit var10 = Unit.INSTANCE;
            var3.setArguments(var6);
            return var3;
        }

        private Companion() {
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
// EmptyFragmentKt.java
package com.example.smartpilow;

        import kotlin.Metadata;

@Metadata(
        mv = {1, 6, 0},
        k = 2,
        d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0003"},
        d2 = {"ARG_PARAM1", "", "ARG_PARAM2", "SmartPilow.app.main"}
)

