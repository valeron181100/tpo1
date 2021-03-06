# Отчет по лабораторной работе №1
## Задание 1

Для указанной функции `cos(x)` провести модульное тестирование разложения функции в степенной ряд. Выбрать достаточное тестовое покрытие.

Тестовое покрытие обрабатывает всю тригонометрическую окружность.

Код одного из тестов

````java
    @Test
    @DisplayName("тест для обычных чисел")
    public void testRandomCos() {
        assertAll(
                () -> assertEquals(0.99995, MyMath.cos(0.01), MyMathTest.accuracy),
                () -> assertEquals(0.825336, MyMath.cos(0.6), MyMathTest.accuracy)
        );
    }
````



## Задание 2
Провести модульное тестирование указанного алгоритма. Для этого выбрать характерные точки внутри алгоритма, и для предложенных самостоятельно наборов исходных данных записать последовательность попадания в характерные точки. Сравнить последовательность попадания с эталонной.

Данные заполненного массива распределены также как и в эталонном.
![схема хеш массива](https://github.com/valeron181100/tpo1/blob/master/images/hashlist.png?raw=true)

Один из тестов

````java
@Test
    @DisplayName("тест на разрешение коллизий")
    public void testResolveCollisions() {
        list.add("wasd");
        int wasdBucketIndex = list.find("wasd");
        int qwerBucketIndex = list.find("qwer");
        System.out.println(list.size());
        assertEquals(qwerBucketIndex, wasdBucketIndex);
    }
````

##Задание 3
Сформировать доменную модель для заданного текста.  Разработать тестовое покрытие для данной доменной модели

Описание предметной области:
*Бомбардировка возобновилась. Жар и шум были невообразимыми. Компьютерный банк начал понемногу разваливаться на куски. Лицевая сторона его почти вся расплавилась, и густые ручейки расплавленного металла начали заползать в угол, в котором они сидели. Они сгрудились плотнее и стали ждать конца. Глава 33*

**UML диаграмма классов**

![UML](https://github.com/valeron181100/tpo1/blob/master/images/uml-3part-first-lab.png?raw=true)

Пример теста

````java
    @Test
    public void testTooManyAttacks() {
        for (int i = 0; i < 10; i++)
            attack.attack();
        assertEquals("Здание уже разрушено!", attack.attack());
    }
````