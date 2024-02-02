import { Component, OnDestroy } from '@angular/core';
import { Observable, Subject, filter, map, takeUntil } from 'rxjs';

@Component({
  selector: 'app-rxjs-test',
  standalone: true,
  imports: [],
  templateUrl: './rxjs-test.component.html',
  styleUrl: './rxjs-test.component.css'
})
export class RxjsTestComponent implements OnDestroy {
  private unsubscribe$ = new Subject<void>();

  // Example 1: Observable
  observableExample(): void {
    const myObservable = new Observable<string>(observer => {
      observer.next('Hello');
      observer.next('World');
      observer.complete();
    });

    myObservable
      .pipe(takeUntil(this.unsubscribe$))
      .subscribe(value => console.log('Observable Example:', value));
  }

  // Example 2: Map
  mapExample(): void {
    const source = new Observable<number>(observer => {
      observer.next(1);
      observer.next(2);
      observer.next(3);
      observer.complete();
    });

    const squared = source.pipe(
      map(x => x * x),
      takeUntil(this.unsubscribe$)
    );

    squared.subscribe(result => console.log('Map Example:', result));
  }

  // Example 3: Filter
  filterExample(): void {
    const source = new Observable<number>(observer => {
      observer.next(1);
      observer.next(2);
      observer.next(3);
      observer.complete();
    });

    const evenNumbers = source.pipe(
      filter(x => x % 2 === 0),
      takeUntil(this.unsubscribe$)
    );

    evenNumbers.subscribe(result => console.log('Filter Example:', result));
  }

  // Example 4: Subject
  subjectExample(): void {
    const mySubject = new Subject<string>();

    mySubject.pipe(takeUntil(this.unsubscribe$)).subscribe(value => console.log('Subject Example:', value));

    mySubject.next('Hello');
    mySubject.next('World');
    mySubject.complete();
  }

  ngOnDestroy(): void {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }
}
