import { Moment } from 'moment';

export interface IJob {
  id?: number;
  version?: string;
  jobId?: string;
  isCurrent?: boolean;
  startTime?: Moment;
  finishTime?: Moment;
  totalGroups?: number;
  totalParcels?: number;
  xNum?: number;
  yNum?: number;
}

export class Job implements IJob {
  constructor(
    public id?: number,
    public version?: string,
    public jobId?: string,
    public isCurrent?: boolean,
    public startTime?: Moment,
    public finishTime?: Moment,
    public totalGroups?: number,
    public totalParcels?: number,
    public xNum?: number,
    public yNum?: number
  ) {
    this.isCurrent = this.isCurrent || false;
  }
}
