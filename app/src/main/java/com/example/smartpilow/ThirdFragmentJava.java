package com.example.smartpilow;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.smartpilow.adapter.ListAdpater;
import com.example.smartpilow.models.Feed;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.ktx.FirestoreKt;
import com.google.firebase.ktx.Firebase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 6, 0},
        k = 1,
        d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"},
        d2 = {"Lcom/example/smartpilow/ThirdFragment;", "Landroidx/fragment/app/Fragment;", "()V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getDb", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "SmartPilow.app.main"}
)
public final class ThirdFragmentJava extends Fragment {
    @NotNull
    private final FirebaseFirestore db;

    @NotNull
    public final FirebaseFirestore getDb() {
        return this.db;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final ObjectRef arrayList = new ObjectRef();
        arrayList.element = new ArrayList();
        View view = inflater.inflate(1300079, container, false);
        final ListView listView = (ListView)view.findViewById(1000095);
        this.db.collection("readings").get().addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((QuerySnapshot)var1);
            }

            public final void onSuccess(QuerySnapshot result) {
                Intrinsics.checkNotNullExpressionValue(result, "result");
                int $i$f$toObjects = false;
                List var10000 = result.toObjects(Feed.class);
                Intrinsics.checkNotNullExpressionValue(var10000, "toObjects(T::class.java)");
                List customResult = var10000;
                Iterator var7 = customResult.iterator();

                while(var7.hasNext()) {
                    Feed documents = (Feed)var7.next();
                    Log.d("TAG", customResult.toString());
                    ((ArrayList)arrayList.element).add(new Feed(documents.getCreated_at(), documents.getEntry_id(), documents.getField1(), documents.getField2(), documents.getField3()));
                    Context var10002 = ThirdFragmentJava.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(var10002, "requireContext()");
                    ListAdpater adapter = new ListAdpater(var10002, (ArrayList)arrayList.element);
                    ListView var6 = listView;
                    Intrinsics.checkNotNullExpressionValue(var6, "listView");
                    var6.setAdapter((ListAdapter)adapter);
                }

            }
        })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
            public final void onFailure(@NotNull Exception result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Toast.makeText(ThirdFragmentJava.this.getContext(), (CharSequence)result.toString(), 1).show();
            }
        }));
        return view;
    }

    public ThirdFragmentJava() {
        this.db = FirestoreKt.getFirestore(Firebase.INSTANCE);
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }
}
