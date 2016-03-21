<div class="modal orders_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="/edit.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update order info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="orders_edit_id" name="order.id" type="hidden">
                        <div class="form-group">
                            <label>Id client: <input type="number" class="form-control" name="order.idClient"></label>
                        </div>
                        <div class="form-group">
                            <label>Date: <input type="date" class="form-control" name="order.date"></label>
                        </div>
                        <div class="form-group">
                            <label>Id doctor: <input type="number" class="form-control" name="order.idDoctor"></label>
                        </div>
                        <div class="form-group">
                            <label>Begin time: <input type="time" class="form-control" name="order.beginTime"></label>
                        </div>
                        <div class="form-group">
                            <label>End time: <input type="time" class="form-control" name="order.endTime"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->