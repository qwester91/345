by.it_academy.jd2.sorts.servlets.ListOfMusician - сервлет возвращающий список музыкантов
urlPatterns = "/ListOfMusician"


by.it_academy.jd2.sorts.servlets.ListOfStyles - сервлет возвращающий список жанров
urlPatterns = "/ListOfStyles"


by.it_academy.jd2.sorts.servlets.Vote - сервлет форма для голосования. Принимает результат через query string,
при корректном вводе параметров печатает чтото жизнеутверждающее,
при некорректном говорит об ошибке.
контролируется только количество введенных значений.

Названия параметров:
musician= музыкант
styles= стиль
info= краткая информация
urlPatterns = "/vote"


by.it_academy.jd2.sorts.servlets.TopMusicians - сервлет возвращающий топ музыкантов по итогам голосования
urlPatterns = "/topMusicians"


by.it_academy.jd2.sorts.servlets.TopMusicians - сервлет возвращающий топ жанров по итогам голосования
urlPatterns = "/topStyles"


by.it_academy.jd2.sorts.servlets.TopMusicians - сервлет возвращающий раткую инфу о пользователях, сортированную по времени
urlPatterns = "/topInfo"


by.it_academy.jd2.sorts.sorters.Sorts - Класс с методом
public List<Map.Entry<String, Integer>> sortMap(Map<String, Integer> choose)

принимает мапу <String,integer>, возвращает сортированный лист Map.Entry<String, Integer>


by.it_academy.jd2.sorts.sorters.SortsInfo - то же что и Sorts только для <String, Long>


by.it_academy.jd2.sorts.comparators.MapComparator - компаратор для Map.Entry<String, Integer> по value
by.it_academy.jd2.sorts.comparators.MapComparatorInfo - компаратор для Map.Entry<String, Long> по value


by.it_academy.jd2.sorts.dto.VoteInfo - Класс накапливает краткую информацию о себе в мапе <String, Long>, где стринг -
информация, а лонг - время в мс.


by.it_academy.jd2.sorts.dto.VoteResultsMusicians - Класс накапливает результаты голосования за музыкантов и запихивает их
в мапу <String, Integer> где стринг - название исполнителя, интегер - количество голосов за него


by.it_academy.jd2.sorts.dto.VoteResultsStyles - Класс накапливает результаты голосования за жанры и запихивает их
в мапу <String, Integer> где стринг - название жанра, интегер - количество голосов за него