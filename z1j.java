import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
    private List<Integer> heap;
    
    public BinaryHeap() {
        heap = new ArrayList<>();
    }
    
    // # Метод для вставки нового элемента в кучу
    public void insert(int value) {
        // # 1. Добавляем новый элемент в конец списка
        heap.add(value);
        
        // # 2. Восстанавливаем свойства кучи, поднимая новый элемент на нужную позицию
        heapifyUp(heap.size() - 1);
    }
    
    // # Вспомогательный метод для восстановления свойств кучи снизу вверх
    private void heapifyUp(int index) {
        // # Пока не дошли до корня
        while (index > 0) {
            // # 3. Находим индекс родительского элемента
            int parentIndex = (index - 1) / 2;
            
            // # 4. Если текущий элемент меньше родительского (min-heap)
            if (heap.get(index) < heap.get(parentIndex)) {
                // # 5. Меняем местами с родителем
                swap(index, parentIndex);
                // # 6. Переходим к родительской позиции
                index = parentIndex;
            } else {
                // # 7. Свойства кучи восстановлены, выходим
                break;
            }
        }
    }
    
    // # Вспомогательный метод для обмена элементов
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    // # Метод для получения корня (минимального элемента)
    public int getMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }
    
    // # Метод для вывода кучи
    public void printHeap() {
        System.out.println("Heap: " + heap);
    }
    
    // # Пример использования
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(15);
        heap.insert(3);
        heap.insert(7);
        
        heap.printHeap(); // # Вывод: Heap: [3, 5, 15, 10, 7]
        System.out.println("Min element: " + heap.getMin()); // # Вывод: Min element: 3
    }
}