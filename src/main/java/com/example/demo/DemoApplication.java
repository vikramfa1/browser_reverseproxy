package com.example.demo;

import com.example.demo.helper.ClusterConfiguratorHelper;
import com.example.demo.service.VertxHttpServerArticle;
import io.vertx.core.VertxOptions;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.core.eventbus.EventBus;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;
import io.vertxbeans.rxjava.VertxBeans;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(VertxBeans.class)
@Slf4j
public class DemoApplication {

	@Autowired
	protected ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		final ClusterManager mgr = new HazelcastClusterManager(ClusterConfiguratorHelper.getHazelcastConfiguration());
		final VertxOptions options = new VertxOptions().setClusterManager(mgr);

		Vertx.clusteredVertx(options, res -> {
			if(res.succeeded()) {
				Vertx vertx = res.result();
				EventBus eventBus = vertx.eventBus();
				log.info("We now have a clustered event bus: " + eventBus);
				log.info("cluster vertx: " + vertx.isClustered());
				VertxHttpServerArticle article = applicationContext.getBean(VertxHttpServerArticle.class);
				vertx.deployVerticle(article, res1 -> {
					if(res1.succeeded()){
						log.info("Deployment id is: {}", res1.result());
					} else {
						log.error("Deployment failed!"+res1.failed()+","+res1.cause());
						res1.cause().printStackTrace();
					}
				});
			} else {
				log.error("Failed: " + res.cause());
			}
		});
	}


}
