package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;
import java.util.Arrays;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

	private static List<Enterprise> enterprises = List.of(new Enterprise("ent_1", "Google", "ceo_2"),
			new Enterprise("ent_2", "Facebook", "ceo_1"));

	private static List<Ceo> ceos = List.of(new Ceo("ceo_1", "Mark"), new Ceo("ceo_2", "Sundar"),
			new Ceo("ceo_3", "Bill"));

	/**
	 * @param ceo_id
	 * @return
	 */
	private static Option<Ceo> findCeoInfoById(String ceo_id) {
		for (Ceo ceo : ceos) {
			if (ceo.id.equals(ceo_id)) {
				return Option.of(ceo);
			}
		}
		return Option.none();
	}

	/**
	 * @param ceo_id
	 * @return
	 */
	public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
		return CompletableFuture.supplyAsync(() -> findCeoInfoById(ceo_id));
	}

	/**
	 * @param ceo_id
	 * @return
	 */
	private static Option<Enterprise> findEntrepriseById(String ceo_id) {
		for (Enterprise e : enterprises) {
			if (e.ceo_id.equals(ceo_id)) {
				return Option.of(e);
			}
		}

		return Option.none();
	}

	/**
	 * @param ceo_id
	 * @return
	 */
	/**
	 * @param ceo_id
	 * @return
	 */
	public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
		return CompletableFuture.supplyAsync(() -> findEntrepriseById(ceo_id));
	}

	/**
	 * @param ceo_id
	 * @return
	 */
	public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {

		return CompletableFuture.supplyAsync(() -> Tuple.of(findCeoInfoById(ceo_id), findEntrepriseById(ceo_id)));
	}

}
