package tech.huning.aurora.util.async;

import com.alibaba.fastjson.JSON;
import tech.huning.aurora.util.async.core.AsyncScheduler;
import tech.huning.aurora.util.async.dto.VideoDTO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.huning.aurora.util.async.specs.*;

import java.util.UUID;

public class AsyncSchedulerTest {

    private static final Logger logger = LoggerFactory.getLogger(AsyncSchedulerTest.class);

    private static final IAsyncTopic TOPIC_VIDEO_TRANSFER = () -> "TOPIC_VIDEO_TRANSFER";

    @Test
    public void test() {

        try {
            startServer();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        try {
            printStocks();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        try {
            printHandlings();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        try {
            startClient();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }


    /**
     * 服务端启动
     * @throws Exception
     */
    private void startServer() throws Exception {
        AsyncScheduler.getInstance().getServer(new IAsyncConfig() {
            @Override
            public int getTaskCapacity() {
                return 10;
            }
            public IAsyncTopic getTopic() {
                return TOPIC_VIDEO_TRANSFER;
            }

        }).register((IAsyncExecutor<VideoDTO>) task -> {

            logger.debug("start process>>>{}-{}", task.getData().getDuration(),
                    task.getData().getTitle());
            //Thread.sleep(2000);
            logger.debug("end process<<<{}-{}", task.getData().getDuration(),
                    task.getData().getTitle());

        }).register((IAsyncOverflowHandler) task -> logger.debug("overflow:{}", JSON.toJSONString(task)))
          .listen();
    }

    /**
     * 服务端关闭
     * @throws Exception
     */
    private void stopServer() throws Exception {
        AsyncScheduler.getInstance().getServer(TOPIC_VIDEO_TRANSFER).shutdown();
    }

    /**
     * 客户端启动
     * @throws Exception
     */
    private void startClient() throws Exception {
        for(long i = 0; i < 50; i++) {
            final long num = i;
            //Thread.sleep(800);
            AsyncScheduler.getInstance().getClient(TOPIC_VIDEO_TRANSFER).schedule(new IAsyncTask<VideoDTO>() {
                private String id = UUID.randomUUID().toString();
                @Override
                public String getId() {
                    return id;
                }
                public VideoDTO getData() {
                    return new VideoDTO("VIDEO-" + num, num);
                }
            });
        }
    }

    private void printStocks() throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        //Thread.sleep(500);
                        IAsyncStock stocks = AsyncScheduler.getInstance().getServer(TOPIC_VIDEO_TRANSFER).getStock();
                        logger.debug("STOCKS:{}|{}", stocks.getTotal(), JSON.toJSONString(stocks));
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private void printHandlings() throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        //Thread.sleep(500);
                        IAsyncHandling handlings = AsyncScheduler.getInstance().getServer(TOPIC_VIDEO_TRANSFER).getHandling();
                        logger.debug("HANDLINGS:{}|{}", handlings.getTotal(), JSON.toJSONString(handlings));
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
}
