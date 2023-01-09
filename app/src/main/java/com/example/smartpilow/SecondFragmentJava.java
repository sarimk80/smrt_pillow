package com.example.smartpilow;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat.Builder;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import com.example.smartpilow.models.Feed;
import com.example.smartpilow.models.SmartPillowModel;
import com.example.smartpilow.services.RetrofitHelper;
import com.example.smartpilow.services.SmartPillowApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ktx.FirestoreKt;
import com.google.firebase.ktx.Firebase;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

@Metadata(
        mv = {1, 6, 0},
        k = 1,
        d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u001f\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"},
        d2 = {"Lcom/example/smartpilow/SecondFragment;", "Landroidx/fragment/app/Fragment;", "()V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getDb", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "createNotification", "", "test", "", "title", "createNotificationChannel", "getResponse", "result", "Lretrofit2/Response;", "Lcom/example/smartpilow/models/SmartPillowModel;", "(Lretrofit2/Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "SmartPilow.app.main"}
)
public final class SecondFragmentJava extends Fragment {
    @NotNull
    private final FirebaseFirestore db;

    @NotNull
    public final FirebaseFirestore getDb() {
        return this.db;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.createNotificationChannel();
        final SmartPillowApi smartPillowApi = (SmartPillowApi)RetrofitHelper.INSTANCE.getInstance().create(SmartPillowApi.class);
        BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
            int label;

            @Nullable
            public final Object invokeSuspend(@NotNull Object $result) {
                Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                Object var10000;
                switch(this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        SmartPillowApi var4 = smartPillowApi;
                        this.label = 1;
                        var10000 = var4.getData(this);
                        if (var10000 == var3) {
                            return var3;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        var10000 = $result;
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                Response result = (Response)var10000;
                SecondFragmentJava var5 = SecondFragmentJava.this;
                this.label = 2;
                if (var5.getResponse(result, this) == var3) {
                    return var3;
                } else {
                    return Unit.INSTANCE;
                }
            }

            @NotNull
            public final Continuation create(@Nullable Object value, @NotNull Continuation completion) {
                Intrinsics.checkNotNullParameter(completion, "completion");
                Function2 var3 = new <anonymous constructor>(completion);
                return var3;
            }

            public final Object invoke(Object var1, Object var2) {
                return ((<undefinedtype>)this.create(var1, (Continuation)var2)).invokeSuspend(Unit.INSTANCE);
            }
        }), 3, (Object)null);
        return inflater.inflate(1300090, container, false);
    }

    private final Object getResponse(final Response result, Continuation $completion) {
        if (result != null) {
            Feed var4;
            label18: {
                SmartPillowModel var10001 = (SmartPillowModel)result.body();
                if (var10001 != null) {
                    List var3 = var10001.getFeeds();
                    if (var3 != null) {
                        var4 = (Feed)CollectionsKt.last(var3);
                        break label18;
                    }
                }

                var4 = null;
            }

            Log.d("secondFragment", String.valueOf(var4));
            Object var10000 = BuildersKt.withContext((CoroutineContext)Dispatchers.getMain(), (Function2)(new Function2((Continuation)null) {
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object var1) {
                    Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0:
                            String var2;
                            List var5;
                            Feed var6;
                            String var7;
                            Integer var8;
                            SmartPillowModel var10000;
                            label154: {
                                ResultKt.throwOnFailure(var1);
                                var10000 = (SmartPillowModel)result.body();
                                if (var10000 != null) {
                                    var5 = var10000.getFeeds();
                                    if (var5 != null) {
                                        var6 = (Feed)CollectionsKt.last(var5);
                                        if (var6 != null) {
                                            var7 = var6.getField1();
                                            if (var7 != null) {
                                                var2 = var7;
                                                var8 = Boxing.boxInt(Integer.parseInt(var2));
                                                break label154;
                                            }
                                        }
                                    }
                                }

                                var8 = null;
                            }

                            Intrinsics.checkNotNull(var8);
                            if (var8 > 95) {
                                SecondFragmentJava.this.createNotification("Your patient heart rate rose above 95 bpm", "High heart rate ");
                            } else {
                                label145: {
                                    var10000 = (SmartPillowModel)result.body();
                                    if (var10000 != null) {
                                        var5 = var10000.getFeeds();
                                        if (var5 != null) {
                                            var6 = (Feed)CollectionsKt.last(var5);
                                            if (var6 != null) {
                                                var7 = var6.getField2();
                                                if (var7 != null) {
                                                    var2 = var7;
                                                    var8 = Boxing.boxInt(Integer.parseInt(var2));
                                                    break label145;
                                                }
                                            }
                                        }
                                    }

                                    var8 = null;
                                }

                                Intrinsics.checkNotNull(var8);
                                if (var8 > 37) {
                                    SecondFragmentJava.this.createNotification("Your patient temperature rose above normal body temperature", "High Temperature Alert");
                                } else {
                                    label137: {
                                        var10000 = (SmartPillowModel)result.body();
                                        if (var10000 != null) {
                                            var5 = var10000.getFeeds();
                                            if (var5 != null) {
                                                var6 = (Feed)CollectionsKt.last(var5);
                                                if (var6 != null) {
                                                    var7 = var6.getField1();
                                                    if (var7 != null) {
                                                        var2 = var7;
                                                        var8 = Boxing.boxInt(Integer.parseInt(var2));
                                                        break label137;
                                                    }
                                                }
                                            }
                                        }

                                        var8 = null;
                                    }

                                    Intrinsics.checkNotNull(var8);
                                    if (var8 > 50) {
                                        Boolean var25;
                                        label129: {
                                            var10000 = (SmartPillowModel)result.body();
                                            if (var10000 != null) {
                                                var5 = var10000.getFeeds();
                                                if (var5 != null) {
                                                    var6 = (Feed)CollectionsKt.last(var5);
                                                    if (var6 != null) {
                                                        var7 = var6.getField3();
                                                        if (var7 != null) {
                                                            var2 = var7;
                                                            var25 = Boxing.boxBoolean(Boolean.parseBoolean(var2));
                                                            break label129;
                                                        }
                                                    }
                                                }
                                            }

                                            var25 = null;
                                        }

                                        Intrinsics.checkNotNull(var25);
                                        if (!var25) {
                                            SecondFragmentJava.this.createNotification("Your patient has woke up from bed", "Wake up Alert");
                                        }
                                    }
                                }
                            }

                            String var11;
                            label122: {
                                var6 = new Feed;
                                SmartPillowModel var10002 = (SmartPillowModel)result.body();
                                if (var10002 != null) {
                                    List var9 = var10002.getFeeds();
                                    if (var9 != null) {
                                        Feed var10 = (Feed)CollectionsKt.last(var9);
                                        if (var10 != null) {
                                            var11 = var10.getCreated_at();
                                            break label122;
                                        }
                                    }
                                }

                                var11 = null;
                            }

                            Long var14;
                            label116: {
                                Intrinsics.checkNotNull(var11);
                                SmartPillowModel var10003 = (SmartPillowModel)result.body();
                                if (var10003 != null) {
                                    List var12 = var10003.getFeeds();
                                    if (var12 != null) {
                                        Feed var13 = (Feed)CollectionsKt.last(var12);
                                        if (var13 != null) {
                                            var14 = Boxing.boxLong(var13.getEntry_id());
                                            break label116;
                                        }
                                    }
                                }

                                var14 = null;
                            }

                            long var17;
                            String var18;
                            label110: {
                                Intrinsics.checkNotNull(var14);
                                var17 = var14;
                                SmartPillowModel var10004 = (SmartPillowModel)result.body();
                                if (var10004 != null) {
                                    List var15 = var10004.getFeeds();
                                    if (var15 != null) {
                                        Feed var16 = (Feed)CollectionsKt.last(var15);
                                        if (var16 != null) {
                                            var18 = var16.getField1();
                                            break label110;
                                        }
                                    }
                                }

                                var18 = null;
                            }

                            String var21;
                            label104: {
                                Intrinsics.checkNotNull(var18);
                                SmartPillowModel var10005 = (SmartPillowModel)result.body();
                                if (var10005 != null) {
                                    List var19 = var10005.getFeeds();
                                    if (var19 != null) {
                                        Feed var20 = (Feed)CollectionsKt.last(var19);
                                        if (var20 != null) {
                                            var21 = var20.getField2();
                                            break label104;
                                        }
                                    }
                                }

                                var21 = null;
                            }

                            String var24;
                            label98: {
                                Intrinsics.checkNotNull(var21);
                                SmartPillowModel var10006 = (SmartPillowModel)result.body();
                                if (var10006 != null) {
                                    List var22 = var10006.getFeeds();
                                    if (var22 != null) {
                                        Feed var23 = (Feed)CollectionsKt.last(var22);
                                        if (var23 != null) {
                                            var24 = var23.getField3();
                                            break label98;
                                        }
                                    }
                                }

                                var24 = null;
                            }

                            Intrinsics.checkNotNull(var24);
                            var6.<init>(var11, var17, var18, var21, var24);
                            Feed feed = var6;
                            View var26 = SecondFragmentJava.this.getView();
                            TextView var27;
                            if (var26 != null) {
                                var27 = (TextView)var26.findViewById(1000341);
                                if (var27 != null) {
                                    var27.setText((CharSequence)("HeartBeat " + feed.getField1()));
                                }
                            }

                            var26 = SecondFragmentJava.this.getView();
                            if (var26 != null) {
                                var27 = (TextView)var26.findViewById(1000268);
                                if (var27 != null) {
                                    var27.setText((CharSequence)("Temperature " + feed.getField2()));
                                }
                            }

                            var26 = SecondFragmentJava.this.getView();
                            if (var26 != null) {
                                var27 = (TextView)var26.findViewById(1000100);
                                if (var27 != null) {
                                    var27.setText((CharSequence)("Is sleeping " + feed.getField3()));
                                }
                            }

                            return SecondFragmentJava.this.getDb().collection("readings").document(String.valueOf(feed.getEntry_id())).set(feed).addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                                // $FF: synthetic method
                                // $FF: bridge method
                                public void onSuccess(Object var1) {
                                    this.onSuccess((Void)var1);
                                }

                                public final void onSuccess(Void task) {
                                    Toast.makeText(SecondFragmentJava.this.getContext(), (CharSequence)"Successfully send to database", 1).show();
                                }
                            })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                                public final void onFailure(@NotNull Exception it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    Toast.makeText(SecondFragmentJava.this.getContext(), (CharSequence)"Failed", 1).show();
                                }
                            }));
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                @NotNull
                public final Continuation create(@Nullable Object value, @NotNull Continuation completion) {
                    Intrinsics.checkNotNullParameter(completion, "completion");
                    Function2 var3 = new <anonymous constructor>(completion);
                    return var3;
                }

                public final Object invoke(Object var1, Object var2) {
                    return ((<undefinedtype>)this.create(var1, (Continuation)var2)).invokeSuspend(Unit.INSTANCE);
                }
            }), $completion);
            if (var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return var10000;
            }
        }

        return Unit.INSTANCE;
    }

    private final void createNotification(String test, String title) {
        Builder var10000 = (new Builder(this.requireContext(), "CHANNEL_ID")).setSmallIcon(700062).setDefaults(1).setContentText((CharSequence)test).setContentTitle((CharSequence)title).setAutoCancel(true).setSound((Uri)null).setContentIntent((PendingIntent)null).setPriority(1);
        Intrinsics.checkNotNullExpressionValue(var10000, "NotificationCompat.Build…tionCompat.PRIORITY_HIGH)");
        Builder notificationBuilder = var10000;
        NotificationManager notificationManager = (NotificationManager)this.requireContext().getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify(123, notificationBuilder.build());
        }

    }

    private final void createNotificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            CharSequence name = (CharSequence)"CHANNEL_ID";
            String description = "Detail about channel";
            int importance = 3;
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", name, importance);
            channel.setDescription(description);
            Object var10000 = this.requireContext().getSystemService("notification");
            if (var10000 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
            }

            NotificationManager notificationManager = (NotificationManager)var10000;
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((Button)view.findViewById(1000153)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                FragmentKt.findNavController(SecondFragmentJava.this).navigate(1000064);
            }
        }));
        ((ImageButton)view.findViewById(1000294)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                final SmartPillowApi smartPillowApi = (SmartPillowApi)RetrofitHelper.INSTANCE.getInstance().create(SmartPillowApi.class);
                BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
                    int label;

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        Object var10000;
                        switch(this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                SmartPillowApi var4 = smartPillowApi;
                                this.label = 1;
                                var10000 = var4.getData(this);
                                if (var10000 == var3) {
                                    return var3;
                                }
                                break;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                var10000 = $result;
                                break;
                            case 2:
                                ResultKt.throwOnFailure($result);
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        Response result = (Response)var10000;
                        SecondFragmentJava var5 = SecondFragmentJava.this;
                        this.label = 2;
                        if (var5.getResponse(result, this) == var3) {
                            return var3;
                        } else {
                            return Unit.INSTANCE;
                        }
                    }

                    @NotNull
                    public final Continuation create(@Nullable Object value, @NotNull Continuation completion) {
                        Intrinsics.checkNotNullParameter(completion, "completion");
                        Function2 var3 = new <anonymous constructor>(completion);
                        return var3;
                    }

                    public final Object invoke(Object var1, Object var2) {
                        return ((<undefinedtype>)this.create(var1, (Continuation)var2)).invokeSuspend(Unit.INSTANCE);
                    }
                }), 3, (Object)null);
            }
        }));
    }

    public SecondFragmentJava() {
        this.db = FirestoreKt.getFirestore(Firebase.INSTANCE);
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }
}
