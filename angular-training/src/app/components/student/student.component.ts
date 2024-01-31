import { Component, Input, OnInit, inject } from '@angular/core';
import { ApiService } from '../../services/api/api.service';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe, NgFor } from '@angular/common';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';


@Component({
  selector: 'app-student',
  standalone: true,
  imports: [HttpClientModule, NgFor, DatePipe, MatTableModule],
  providers : [ApiService],
  templateUrl: './student.component.html',
  styleUrl: './student.component.css',
})

export class StudentComponent implements OnInit {
  @Input() parentMessage: string | undefined;

  students: any[] = [];
  displayedColumns: string[] = ['id', 'name', 'dateOfBirth', 'average'];
  dataSource: MatTableDataSource<any>;

  constructor(private apiService: ApiService) {
    this.dataSource = new MatTableDataSource(this.students);
  }

  ngOnInit() {
    this.apiService.get('students').subscribe(
      (response) => {
        this.students = response;
        this.dataSource.data = this.students;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }
}