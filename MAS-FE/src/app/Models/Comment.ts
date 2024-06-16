export class  Comment{
  constructor(
    public id: number,
    public text: string,
    public createdDate: Date,
    public authorEmail: string
  ) {
  }
}
