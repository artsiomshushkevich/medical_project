<div class="modal schedules_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="/update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update schedule info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="schedules_edit_id" name="schedule.id" type="hidden">
                        <div class="form-group">
                            <label>Id doctor: <input type="number" class="form-control" name="schedule.idDoctor"></label>
                        </div>
                        <div class="form-group">
                            <label>Week day: <input type="text" class="form-control" name="schedule.weekDay"></label>
                        </div>
                        <div class="form-group">
                            <label>Begin workday: <input type="text" class="form-control" name="schedule.beginWorkday"></label>
                        </div>
                        <div class="form-group">
                            <label>End workday: <input type="text" class="form-control" name="schedule.endWorkday"></label>
                        </div>
                        <div class="form-group">
                            <label>Duration: <input type="time" class="form-control" name="schedule.duration"></label>
                        </div>
                        <div class="form-group">
                            <label>Cabinet: <input type="number" class="form-control" name="schedule.cabinet"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save changes</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->