package io.hyperfoil.api.session;

import java.util.List;

import io.hyperfoil.api.collection.ElasticPool;
import io.hyperfoil.api.config.Phase;
import io.hyperfoil.api.statistics.Statistics;
import io.netty.util.concurrent.EventExecutorGroup;

public interface PhaseInstance {
   Phase definition();

   Status status();

   void proceed(EventExecutorGroup executorGroup);

   long absoluteStartTime();

   void start(EventExecutorGroup executorGroup);

   void finish();

   void tryTerminate();

   void terminate();

   // TODO better name
   void setComponents(ElasticPool<Session> sessionPool, List<Session> sessionList, Iterable<Statistics> statistics, PhaseChangeHandler phaseChangeHandler);

   void reserveSessions();

   void notifyFinished(Session session);

   void notifyTerminated(Session session);

   void setTerminated();

   void fail(Throwable error);

   Throwable getError();

   enum Status {
      NOT_STARTED,
      RUNNING,
      FINISHED,
      TERMINATING,
      TERMINATED;

      public boolean isFinished() {
         return this.ordinal() >= FINISHED.ordinal();
      }
   }
}
