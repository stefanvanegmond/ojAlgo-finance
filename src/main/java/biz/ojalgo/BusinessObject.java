/*
 * Copyright 1997-2018 Optimatika
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package biz.ojalgo;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <ul>
 * <li>Each/every business object interface should extends this {@link BusinessObject} interface (and
 * preferably nothing else). Don't build hierarchies among the business object interfaces. If some interfaces
 * have common properties they can/should extend some common package-private (not public) interface that does
 * not exted BusinessObject.</li>
 * <li>Every interface should have an inner abstract static class named Logic. These classes contain static
 * business logic methods defined in terms of the interfaces. Those methods are the real reason the business
 * object interfaces exist. Do NOT add anything to the interfaces that is not required by any of the business
 * logic methods!</li>
 * <li>Try to avoid defining relationships to other BusinessObject in the interfaces, particularly to-many
 * relationships. Prefer having the logic methods take collections as input parameters.</li>
 * </ul>
 *
 * @author apete
 */
public interface BusinessObject {

    abstract class Logic {

        public static <E> List<E> getEmptyList() {
            return Collections.emptyList();
        }

        public static <K, V> Map<K, V> getEmptyMap() {
            return Collections.emptyMap();
        }

        public static <E> Set<E> getEmptySet() {
            return Collections.emptySet();
        }

        public static <E> List<E> makeSingleEntryList(final E aListEntry) {
            return Collections.singletonList(aListEntry);
        }

        public static <K, V> Map<K, V> makeSingleEntryMap(final K aMapEntryKey, final V aMapEntryValue) {
            return Collections.singletonMap(aMapEntryKey, aMapEntryValue);
        }

        public static <E> Set<E> makeSingleEntrySet(final E aSetEntry) {
            return Collections.singleton(aSetEntry);
        }

    }

    String toDisplayString();

}
