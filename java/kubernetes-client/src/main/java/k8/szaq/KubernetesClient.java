package k8.szaq;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1ObjectMeta;
import io.kubernetes.client.models.V1Service;
import io.kubernetes.client.models.V1ServiceList;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.KubeConfig;

public class KubernetesClient {

	private static final Logger LOG = LoggerFactory.getLogger(KubernetesClient.class);

	public static void main(String[] args) throws IOException, ApiException {
		LOG.info("Test kubernetes");
		ApiClient client = Config.fromConfig(KubeConfig.loadDefaultKubeConfig());
		Configuration.setDefaultApiClient(client);

		CoreV1Api api = new CoreV1Api();

		V1ServiceList list = api.listServiceForAllNamespaces(null, null, null, null, null, null, null, null, null);
		for (V1Service item : list.getItems()) {
			V1ObjectMeta metadata = item.getMetadata();
			String name = metadata.getName();

			LOG.info("{} {}", metadata.getUid(), name);
		}
	}
}
