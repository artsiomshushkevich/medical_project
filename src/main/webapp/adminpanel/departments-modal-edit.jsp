<div class="modal departments_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="departments-update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update department info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="departments_edit_id" name="department.id" type="hidden">
                        <div class="form-group">
                            <label>Name: <input id="departments_edit_name" type="text" required class="form-control" name="department.name"></label>
                        </div>
                        <div class="form-group">
                            <label>Address: <input id="departments_edit_address" type="text" required class="form-control" name="department.address"></label>
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
