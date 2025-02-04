import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {2, 1, 0},
        k = 2,
        xi = 50,
        d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007\u001a\u0006\u0010\b\u001a\u00020\u0001¨\u0006\t"},
        d2 = {"launch3", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "main", "app_debugUnitTest"}
)
public final class UnsafeFlowKt {
    public static final void main() {
        launch3((Function1)(new Function1((Continuation)null) {
            int label;

            public final Object invokeSuspend(Object $result) {
                String var2;
                label17: {
                    Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    Continuation var10001;
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            var2 = "before";
                            System.out.print(var2);
                            var10001 = (Continuation)this;
                            this.label = 1;
                            if (DelayKt.delay(1000L, var10001) == var3) {
                                return var3;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            break label17;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    var2 = "\nmiddle";
                    System.out.print(var2);
                    var10001 = (Continuation)this;
                    this.label = 2;
                    if (DelayKt.delay(1000L, var10001) == var3) {
                        return var3;
                    }
                }

                var2 = "\nafter";
                System.out.print(var2);
                return Unit.INSTANCE;
            }

            public final Continuation create(Continuation $completion) {
                return (Continuation)(new <anonymous constructor>($completion));
            }

            public final Object invoke(Continuation p1) {
                return ((<undefinedtype>)this.create(p1)).invokeSuspend(Unit.INSTANCE);
            }

            // $FF: synthetic method
            // $FF: bridge method
            public Object invoke(Object p1) {
                return this.invoke((Continuation)p1);
            }
        }));
        Thread.sleep(3000L);
    }

    public static final void launch3(@NotNull Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Continuation coroutine = IntrinsicsKt.createCoroutineUnintercepted(block, (Continuation)(new Continuation() {
            public CoroutineContext getContext() {
                return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
            }

            public void resumeWith(Object result) {
                String var2 = "\nresumeWith=" + Result.toString-impl(result);
                System.out.println(var2);
            }
        }));
        Result.Companion var10001 = Result.Companion;
        coroutine.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    // $FF: synthetic method
    public static void main(String[] args) {
        main();
    }
}

